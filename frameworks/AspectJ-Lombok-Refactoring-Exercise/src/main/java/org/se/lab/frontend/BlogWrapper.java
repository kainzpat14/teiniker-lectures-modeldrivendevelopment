package org.se.lab.frontend;

import java.util.List;
import java.util.stream.Collectors;

import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;
import org.se.lab.business.rules.IBlogService;
import org.se.lab.frontend.dto.BlogEntryDTO;
import org.se.lab.frontend.dto.UserDTO;

public class BlogWrapper implements IBlogWrapper {

	private ISession session;
	private IBlogService blogService;

	public BlogWrapper(ISession session, IBlogService blogService) {
		super();
		this.session = session;
		this.blogService = blogService;
	}

	@Override
	public BlogEntryDTO createEntry(String header, String message) {
		String method = "createEntry(" + header + "," + message + ")";
		System.out.println(method + " started");
		try {
			if (header == null) {
				throw new IllegalArgumentException("Header must not be null");
			}
			if (message == null) {
				throw new IllegalArgumentException("Message must not be null");
			}
			User user = validateLogin();

			BlogEntry entry = blogService.createEntry(user, header, message);
			BlogEntryDTO dto = new BlogEntryDTO(entry.getId(), new UserDTO(user.getUsername()), entry.getHeading(),
					entry.getMessage());
			System.out.println(method + " resulted in " + dto);
			return dto;
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

	private User validateLogin() {
		User user = session.getUser();
		if (user == null) {
			throw new IllegalArgumentException("You need to be logged in to perform this operation");
		}
		return user;
	}

	@Override
	public List<BlogEntryDTO> listEntries() {
		String method = "listEntries()";
		System.out.println(method + " started");
		try {

			validateLogin();

			List<BlogEntry> entries = blogService.listEntries();
			List<BlogEntryDTO> dtos = entries.stream().map(entry -> new BlogEntryDTO(entry.getId(),
					new UserDTO(entry.getUser().getUsername()), entry.getHeading(), entry.getMessage()))
					.collect(Collectors.toList());
			System.out.println(method + " resulted in " + dtos);
			return dtos;
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

	@Override
	public void deleteEntry(BlogEntryDTO blogEntry) {
		String method = "deleteEntry(" + blogEntry + ")";
		System.out.println(method + " started");
		try {
			if (blogEntry == null) {
				throw new IllegalArgumentException("BlogEntry must not be null");
			}

			User user = validateLogin();

			BlogEntry entry = blogService.findById(blogEntry.getId());

			if (entry == null) {
				throw new IllegalArgumentException("BlogEntry " + blogEntry + " not found");
			}

			if (!entry.getUser().equals(user)) {
				throw new IllegalArgumentException("BlogEntry " + blogEntry + " does not belong to you");
			}
			blogService.deleteBlogEntry(entry);
			System.out.println(method + " resulted in null");
		} catch (Throwable t) {
			System.out.println(method + " failed with ");
			t.printStackTrace();
			throw new IllegalArgumentException(t.getMessage());
		}
	}

}
