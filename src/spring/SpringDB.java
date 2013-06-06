package spring;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
@SuppressWarnings("unused")
@PersistenceCapable 
public class SpringDB 
{
		@PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Key key;
	    @Persistent
	    String firstName;
	    @Persistent
	    String lastName;
	    @Persistent
	    String emailId;
	    @Persistent
	    String password;
	    @Persistent
	    String password1;
	    @Persistent
	    private BlobKey blobKey;
		public SpringDB(String firstName, String lastName, String password,String password1, String emailId, BlobKey blobkey) {
		         this.firstName = firstName;
		         this.lastName =  lastName;
		         this.emailId =  emailId;
		         this. password = password;
		         this.password1 = password1;
		         this.blobKey = blobkey;
		     }
		public Key getKey() {
			return key;
		}
		public void setKey(Key key) {
			this.key = key;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPassword1() {
			return password1;
		}
		public void setPassword1(String password1) {
			this.password1 = password1;
		}
		public BlobKey getBlobKey() {
			return blobKey;
		}
		public void setBlobKey(BlobKey blobKey) {
			this.blobKey = blobKey;
		}
		
		}




