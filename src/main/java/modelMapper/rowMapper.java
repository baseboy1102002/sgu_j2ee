package modelMapper;

import java.sql.ResultSet;

public interface rowMapper<T> {
	T mapRow(ResultSet rs);
}
