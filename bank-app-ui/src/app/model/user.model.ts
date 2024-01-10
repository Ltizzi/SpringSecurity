export class User {
  public customer_id: number;
  public name: string;
  public mobileNumber: string;
  public email: string;
  public password: string;
  public role: string;
  public statusCd: string;
  public statusMsg: string;
  public authStatus: string;

  constructor(
    customer_id?: number,
    name?: string,
    mobileNumber?: string,
    email?: string,
    password?: string,
    role?: string,
    statusCd?: string,
    statusMsg?: string,
    authStatus?: string
  ) {
    this.customer_id = customer_id || 0;
    this.name = name || "";
    this.mobileNumber = mobileNumber || "";
    this.email = email || "";
    this.password = password || "";
    this.role = role || "";
    this.statusCd = statusCd || "";
    this.statusMsg = statusMsg || "";
    this.authStatus = authStatus || "";
  }
}
