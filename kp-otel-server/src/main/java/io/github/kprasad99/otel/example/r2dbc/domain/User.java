package io.github.kprasad99.otel.example.r2dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("tbl_user")
public class User {
	@Id
	private int id;
	private String name;
	private int age;
}
