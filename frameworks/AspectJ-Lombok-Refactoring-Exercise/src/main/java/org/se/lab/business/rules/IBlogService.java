package org.se.lab.business.rules;

import java.util.List;

import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;

public interface IBlogService {
	BlogEntry createEntry(User user, String header, String message);

	List<BlogEntry> listEntries();

	BlogEntry findById(int id);

	void deleteBlogEntry(BlogEntry entry);
}
