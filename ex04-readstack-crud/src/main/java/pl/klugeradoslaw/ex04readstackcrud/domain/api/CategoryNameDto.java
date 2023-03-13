package pl.klugeradoslaw.ex04readstackcrud.domain.api;

public class CategoryNameDto {
    private Integer id;
    private String name;

    public CategoryNameDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
