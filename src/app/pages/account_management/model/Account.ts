export interface Account
{

  id_Account : number;
  account_number : number;


    //  client:Client;
   // type : Category_Account;

    bic : String;
    iban : String;
    balance : number;
    creation_date : Date;
    is_suspended : number;

}
