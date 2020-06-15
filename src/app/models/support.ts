import {Client} from "./Client";

export interface Support {

    idTicket : number;
    client : Client;
    name : string;
    email : string;
    country : string;
    title : string;
    message : string;
    isOpen : boolean;
    date : Date;

}
