package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.business.rules.BlogService;
import org.se.lab.business.rules.IBlogService;
import org.se.lab.business.rules.IUserService;
import org.se.lab.business.rules.UserService;
import org.se.lab.frontend.BlogWrapper;
import org.se.lab.frontend.IBlogWrapper;
import org.se.lab.frontend.ISession;
import org.se.lab.frontend.IUserWrapper;
import org.se.lab.frontend.MemorySession;
import org.se.lab.frontend.UserWrapper;
import org.se.lab.frontend.dto.BlogEntryDTO;
import org.se.lab.persistence.MemoryBlogDao;
import org.se.lab.persistence.MemoryUserDao;

public class BlogTester {

	private IBlogWrapper blogWrapper;
	private IUserWrapper userWrapper;

	@Before
	public void setupWrappers() {
		IUserService userService = new UserService(new MemoryUserDao());
		IBlogService blogService = new BlogService(new MemoryBlogDao());
		ISession session = new MemorySession();
		blogWrapper = new BlogWrapper(session, blogService);
		userWrapper = new UserWrapper(session, userService);
	}

	@Test
	public void testRegister() {
		userWrapper.register("user1", "password1", "password1");
		userWrapper.register("user2", "password2", "password2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRegisterFailed() {
		userWrapper.register("user1", "password1", "password2");
	}

	@Test
	public void testLoginSuccess() {
		testRegister();
		Assert.assertNotNull(userWrapper.login("user1", "password1"));
	}

	@Test
	public void testLoginFailed() {
		testRegister();
		Assert.assertNull(userWrapper.login("user1", "password2"));
	}

	@Test
	public void testIsLoggedIn() {
		testLoginSuccess();
		Assert.assertTrue(userWrapper.isLoggedIn());
	}

	@Test
	public void testIsNotLoggedIn() {
		Assert.assertFalse(userWrapper.isLoggedIn());
	}

	@Test
	public void testCreateBlogEntry() {
		testLoginSuccess();
		Assert.assertNotNull(blogWrapper.createEntry("My first entry", "yay"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotLoggedInCreate() {
		blogWrapper.createEntry("Failure", "This won't work");
	}

	@Test
	public void testList() {
		testCreateBlogEntry();
		Assert.assertEquals(1, blogWrapper.listEntries().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotLoggedInList() {
		blogWrapper.listEntries();
	}

	@Test
	public void testDelete() {
		testCreateBlogEntry();
		BlogEntryDTO dto = blogWrapper.listEntries().get(0);
		blogWrapper.deleteEntry(dto);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoDeleteOtherUser() {
		testCreateBlogEntry();
		BlogEntryDTO dto = blogWrapper.listEntries().get(0);
		userWrapper.login("user2", "password2");
		blogWrapper.deleteEntry(dto);
	}
}
