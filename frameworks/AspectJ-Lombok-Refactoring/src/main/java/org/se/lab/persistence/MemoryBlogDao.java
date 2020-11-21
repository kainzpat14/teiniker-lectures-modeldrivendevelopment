package org.se.lab.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;
import org.se.lab.business.persistence.IBlogDao;

public class MemoryBlogDao implements IBlogDao {

	private int id = 0;
	private List<BlogEntry> entries = new ArrayList<BlogEntry>();

	@Override
	public BlogEntry createBlogEntry(User user, Date timestamp, String header, String message) {
		BlogEntry entry = new BlogEntry(id, user, timestamp, header, message);
		entries.add(entry);
		id++;
		return entry;
	}

	@Override
	public List<BlogEntry> getBlogEntries() {
		return Collections.unmodifiableList(entries);
	}

	@Override
	public List<BlogEntry> getBlogEntriesByUser(User user) {
		return entries.stream().filter(entry -> entry.getUser().getUsername().contentEquals(user.getUsername()))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteBlogEntry(BlogEntry entryToRemove) {
		entries.remove(entryToRemove);
	}

	@Override
	public BlogEntry findById(int id) {
		return entries.stream().filter(entry -> entry.getId() == id).findAny().orElse(null);
	}

}
