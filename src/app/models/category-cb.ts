import {Checkbook} from "./Checkbook";

export interface CategoryCB {
  idCb : number;
  name : string;
  description : string;
  checkbooks : Array<Checkbook>;

}
