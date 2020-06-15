import {Account} from "./Account";

export interface CategoryAccount {

  id : number;
  name : string;
  description : string;
  accounts : Array<Account>;
}
