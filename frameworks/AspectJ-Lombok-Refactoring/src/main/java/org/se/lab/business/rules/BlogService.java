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
		return blogDao.createBlogEntry(user, new Date(), header, message);
	}

	@Override
	public List<BlogEntry> listEntries() {
		return blogDao.getBlogEntries();
	}

	@Override
	public void deleteBlogEntry(BlogEntry entry) {
		blogDao.deleteBlogEntry(entry);
	}

	@Override
	public BlogEntry findById(int id) {
		return blogDao.findById(id);
	}

}
