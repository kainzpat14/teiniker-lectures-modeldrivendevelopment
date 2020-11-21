package org.se.lab.frontend;

import java.util.List;

import org.se.lab.frontend.dto.BlogEntryDTO;

public interface IBlogWrapper {
	BlogEntryDTO createEntry(String header, String message);

	List<BlogEntryDTO> listEntries();

	void deleteEntry(BlogEntryDTO blogEntry);
}
