package Entity;

public enum RoomType {

    S("Single"), D("Double"), Q("Queen"), T("Triple"), QU("Quad");
    private String type;

    RoomType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
