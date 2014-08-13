/**
 * 
 */
package com.priceit.utilities;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

/**
 * Factory used to create KeyHolders which are being used in the DAO classes.
 * Extremely helpful for testing purposes.
 * 
 */
@Component
public class KeyHolderFactory {

	/**
	 * Factory method for creating GeneratedKeyHolders. Required for testing
	 * purposes.
	 * 
	 * @return GeneratedKeyHoler object
	 */
	public GeneratedKeyHolder getKeyHolder() {
		return new GeneratedKeyHolder();
	}

}
