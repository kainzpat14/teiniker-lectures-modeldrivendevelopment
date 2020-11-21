package org.se.lab.business.rules;

import java.util.Date;
import java.util.List;

import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;
import org.se.lab.business.persistence.IBlogDao;

public class BlogService implements IBlogService {

	private IBlogDao blogDao;

	public BlogService(IBlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public BlogEntry createEntry(User user, String header, String message) {
		long start = System.currentTimeMillis();
		BlogEntry entry = blogDao.createBlogEntry(user, new Date(), header, message);
		System.out.println("createEntry() took " + (System.currentTimeMillis() - start) + "ms");
		return entry;
	}

	@Override
	public List<BlogEntry> listEntries() {
		long start = System.currentTimeMillis();
		List<BlogEntry> entries = blogDao.getBlogEntries();
		System.out.println("listEntries() took " + (System.currentTimeMillis() - start) + "ms");
		return entries;
	}

	@Override
	public void deleteBlogEntry(BlogEntry entry) {
		long start = System.currentTimeMillis();
		blogDao.deleteBlogEntry(entry);
		System.out.println("deleteBlogEntry() took " + (System.currentTimeMillis() - start) + "ms");
	}

	@Override
	public BlogEntry findById(int id) {
		long start = System.currentTimeMillis();
		BlogEntry entry = blogDao.findById(id);
		System.out.println("findById() took " + (System.currentTimeMillis() - start) + "ms");
		return entry;
	}

}
