package org.cannonbank.core.Security.controllers;


import org.cannonbank.core.Security.models.ERole;
import org.cannonbank.core.Security.models.Role;
import org.cannonbank.core.Security.models.User;
import org.cannonbank.core.Security.payload.request.LoginRequest;
import org.cannonbank.core.Security.payload.request.SignupRequest;
import org.cannonbank.core.Security.payload.response.JwtResponse;
import org.cannonbank.core.Security.payload.response.MessageResponse;
import org.cannonbank.core.Security.repository.RoleRepository;
import org.cannonbank.core.Security.repository.UserRepository;
import org.cannonbank.core.Security.security.jwt.JwtUtils;
import org.cannonbank.core.Security.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
/*RequestMapping("/requesting")
	public void requesting( @RequestBody Object obj) {

		System.out.println(obj);
		RequestInterceptor.init();
	}
*/
	@PostMapping("/signin")

	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

			System.out.println(jwtUtils.getTenantIdFromJwtToken(jwt));
/*
		RequestInterceptor.myTenant(jwt);
		TenantContext.setCurrentTenant(jwtUtils.getTenantIdFromJwtToken(jwt));
		System.out.println("tenant context var:");
		System.out.println(	TenantContext.getCurrentTenant());
		*/

/**
 *  Database multitenancy treatement, and invokation of class
 *
 */

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 userDetails.getTenantId(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							"Tenant_"+signUpRequest.getUsername()
		);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "agent":
					Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(agentRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
