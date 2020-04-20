package center.authority;

public enum AuthorityEnum {

    ADD("add"), DELETE("delete"), MODIFY("modify"), SELECT("select");

    String action;

    AuthorityEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
