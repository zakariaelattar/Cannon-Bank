import {CategoryCB} from "./category-cb";

export interface Checkbook
{
    idCb : number;
    account : Account;
    categoryCb : CategoryCB;
    is_finished : number;

}
