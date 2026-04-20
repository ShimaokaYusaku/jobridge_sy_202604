package model;

import java.time.LocalDate;

public class ClientExpirationUpdate {
	  private LocalDate expirationnext;


	  public ClientExpirationUpdate() {}
	  public ClientExpirationUpdate(LocalDate expirationnext) {
	    this.expirationnext = expirationnext;
	  }
	  
	  public LocalDate getExpirationnext() {
		return expirationnext;
	}
	  public void setExpirationnext(LocalDate expirationnext) {
		  this.expirationnext = expirationnext;
	  }

}
