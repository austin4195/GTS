package me.nickimpact.gts.api.holders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nickimpact.gts.api.enums.CommandResults;
import me.nickimpact.gts.api.listings.entries.Entry;
import me.nickimpact.gts.api.listings.entries.EntryUI;
import me.nickimpact.gts.api.wrappers.CmdResultWrapper;
import me.nickimpact.gts.api.wrappers.CmdSourceWrapper;

import java.util.List;
import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public abstract class EntryClassification<T> {
	/** Represents the classification of an entry */
	private Class<? extends Entry> classification;

	/** Represents the identifiable name for an entry classification */
	private List<String> identifers;

	/** Represents the item type that will serve as the representation for this classification */
	private String itemRep;

	/** Represents the UI that'll be used to handle necessary functionality of the selling operations */
	private EntryUI ui;

	/** Represents the command functionality for an entry */
	private BiFunction<T, String[], CommandResults> cmdHandler;

	public String getPrimaryIdentifier() {
		return identifers.size() > 0 ? identifers.get(0) : "???";
	}

	public List<String> getAllIdentifiers() {
		return identifers;
	}
}
