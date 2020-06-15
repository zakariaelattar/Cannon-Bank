import {Banker} from "./Banker";
import {Support} from "./support";
import {Account} from "./Account";
import {Request} from "./Request";

export interface Client
{

  id_client : number;
  banker : Banker;
  fname : string;
  lname : string;
  email : string;
  address : string;
  cni : string;
  phone : string;
  birthDate : Date;
  joiningDate : Date;
  isSuspended : boolean;
  supports : Array<Support>;
  accounts : Array<Account>;
  requests : Array<Request>


}
