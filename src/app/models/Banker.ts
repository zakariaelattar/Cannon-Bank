import {Client} from "./Client";
import {Agency} from "./agency";

export interface Banker {

  idBanker : number;
   agency : Agency;
   fname : string;
   lname : string;
   email : string;
   address : string;
   phone :string;
   birthDate : Date;
   joiningDate :Date;
   clients : Array<Client>;


}
