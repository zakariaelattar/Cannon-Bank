export interface Request{
  id_request:number;
 // client : Client;

  /**
   *Type de la demande :
   * - Carte de crédit
   * - Carnet de chèque
   * */
  type : String;
  //  category : Category;

    date:Date;
    is_open:number;

}
