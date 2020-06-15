import {Request} from "./Request";

export interface CategoryRequest {

  id : number;
  name : string;
  description : string;
  requests : Array<Request>;

}
