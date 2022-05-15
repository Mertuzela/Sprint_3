//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package courier;

public class CourierCredentials {
    private String login;
    private String password;

    public CourierCredentials(Courier courier) {
        this.login = courier.getLogin();
        this.password = courier.getPassword();
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier);
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CourierCredentials)) {
            return false;
        } else {
            CourierCredentials other = (CourierCredentials)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$login = this.getLogin();
                Object other$login = other.getLogin();
                if (this$login == null) {
                    if (other$login != null) {
                        return false;
                    }
                } else if (!this$login.equals(other$login)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CourierCredentials;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $login = this.getLogin();
        int result = result * 59 + ($login == null ? 43 : $login.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        return "CourierCredentials(login=" + this.getLogin() + ", password=" + this.getPassword() + ")";
    }
}
