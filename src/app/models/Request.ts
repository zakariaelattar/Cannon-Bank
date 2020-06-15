import {Client} from "./Client";
import {CategoryRequest} from "./category-request";
import {RequestPayload} from "./request-payload";

export interface Request{

  idRequest : number;
  categoryRequest : CategoryRequest;
  client : Client;
  date : Date;
  isOpen : boolean;
  requestPayload : RequestPayload;
}
