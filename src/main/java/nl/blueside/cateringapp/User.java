package nl.blueside.cateringapp;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.NaturalId;
import org.json.JSONObject;
import javax.persistence.Table;

@Entity
public class User
{
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String secret;
    private boolean enabled;
    
    private String jwt;

    @Column(length = 64)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

    private Collection<Role> roles;

    public User() {
        super();
        //TODO: Implement random secret
        this.secret = "zeg ik nie";
        this.enabled = false;
    }

    public Long getId() { return id; }
    public void setId(final Long id) { this.id = id; }
    
	public String getFirstName() { return lastName; }
	public void setFirstName(final String lastName) { this.lastName = lastName; }

    public String getLastName() { return lastName; }
	public void setLastName(final String lastName) { this.lastName = lastName; }

	public String getEmail() { return email; }
	public void setEmail(final String email) { this.email = email; }

    public String getPassword() { return password; }
	public void setPassword(final String password) { this.password = password; }

    public String getJwt() { return jwt; }
	public void setJwt(final String jwt) { this.jwt = jwt; }

    Collection<Role> getRoles() { return this.roles; }
    public void setRoles(final Collection<Role> roles) { this.roles = roles; }

    public void setSecret(final String secret) { this.secret = secret; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }

        final User user = (User) obj;
        if (!email.equals(user.email)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder
            .append("User [id=").append(id)
            .append(", firstName=").append(firstName)
            .append(", lastName=").append(lastName)
            .append(", email=").append(email)
            .append(", password=").append(password)
            .append(", enabled=").append(enabled)
            .append(", jwt=").append(jwt)
            //.append(", isUsing2FA=").append(isUsing2FA)
            .append(", secret=").append(secret)
            .append(", roles=").append(roles)
            .append("]");
        return builder.toString();
    }


    
}
