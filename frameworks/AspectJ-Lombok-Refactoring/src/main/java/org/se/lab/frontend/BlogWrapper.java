package org.se.lab.frontend;

import java.util.List;
import java.util.stream.Collectors;

import org.se.lab.aspects.RequiresLogin;
import org.se.lab.business.model.BlogEntry;
import org.se.lab.business.model.User;
import org.se.lab.business.rules.IBlogService;
import org.se.lab.frontend.dto.BlogEntryDTO;
import org.se.lab.frontend.dto.UserDTO;

import lombok.NonNull;

public class BlogWrapper implements IBlogWrapper {

	private ISession session;
	private IBlogService blogService;

	public BlogWrapper(ISession session, IBlogService blogService) {
		super();
		this.session = session;
		this.blogService = blogService;
	}

	@RequiresLogin
	@Override
	public BlogEntryDTO createEntry(@NonNull String header, @NonNull String message) {
		User user = session.getUser();

		BlogEntry entry = blogService.createEntry(user, header, message);
		return new BlogEntryDTO(entry.getId(), new UserDTO(user.getUsername()), entry.getHeading(),
				entry.getMessage());
	}

	@RequiresLogin
	@Override
	public List<BlogEntryDTO> listEntries() {
		List<BlogEntry> entries = blogService.listEntries();
		return entries.stream().map(entry -> new BlogEntryDTO(entry.getId(),
				new UserDTO(entry.getUser().getUsername()), entry.getHeading(), entry.getMessage()))
				.collect(Collectors.toList());
	}

	@RequiresLogin
	@Override
	public void deleteEntry(@NonNull BlogEntryDTO blogEntry) {
			User user = session.getUser();

			BlogEntry entry = blogService.findById(blogEntry.getId());

			if (entry == null) {
				throw new IllegalArgumentException("BlogEntry " + blogEntry + " not found");
			}

			if (!entry.getUser().equals(user)) {
				throw new IllegalArgumentException("BlogEntry " + blogEntry + " does not belong to you");
			}
			blogService.deleteBlogEntry(entry);
	}

}
