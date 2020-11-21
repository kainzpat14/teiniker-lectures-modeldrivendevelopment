package org.se.lab.business.persistence;

import java.util.Date;
import java.util.List;

import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;

public interface IBlogDao {
	BlogEntry createBlogEntry(User user, Date timestamp, String header, String message);

	List<BlogEntry> getBlogEntries();

	List<BlogEntry> getBlogEntriesByUser(User user);

	void deleteBlogEntry(BlogEntry entry);

	BlogEntry findById(int id);
}
