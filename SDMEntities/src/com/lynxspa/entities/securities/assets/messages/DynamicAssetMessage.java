package com.lynxspa.entities.securities.assets.messages;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dynamic.message")
public class DynamicAssetMessage extends AssetMessage{
	private static final long serialVersionUID = 6413370936021579484L;
}
