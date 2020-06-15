import {Banker} from "./Banker";

export interface Agency {
  idAgency : number;
  name : string;
  address : string;
  country : string;
  email : string;
  phone : string;
  fax : string;
  bankers : Array<Banker>;
  locations : Location;

}
