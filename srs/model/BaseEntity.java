package model;

public abstract class BaseEntity {
    protected Long id;
    protected String name;

    public BaseEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getType();
    public abstract String getDescription();

    public String info() {
        return id + ": " + name;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }

}
