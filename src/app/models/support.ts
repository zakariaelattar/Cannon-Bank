import {Client} from "./Client";

export interface Support {

    client : Client;
    subject : String;
    message : String;
    replyMethod : String;

}
