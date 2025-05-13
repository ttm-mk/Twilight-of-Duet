package com.twilightofduet.Common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.twilightofduet.Character.RomanceCharacterEntity;
import com.twilightofduet.Character.RomanceCharacterRepository;

/*
 * MasterDataLoader
 * 作成者 tsutsumi miki
 * 編集日 2025/5/13 tsutsumi miki
 */


@Component
public class MasterDataLoader implements CommandLineRunner {
	private final RomanceCharacterRepository romanceCharacterRepository;
	
	public MasterDataLoader(RomanceCharacterRepository romanceCharacterRepository) {
		this.romanceCharacterRepository = romanceCharacterRepository;
	}
	
	@Override
	public void run(String... args) {
		if (romanceCharacterRepository.count() == 0) {
			romanceCharacterRepository.save(new RomanceCharacterEntity("園山巧美"));
			romanceCharacterRepository.save(new RomanceCharacterEntity("小早川颯真"));
			romanceCharacterRepository.save(new RomanceCharacterEntity("須王御幸"));
			romanceCharacterRepository.save(new RomanceCharacterEntity("園山巧斗"));
			romanceCharacterRepository.save(new RomanceCharacterEntity("相良実瑠"));
		}
	}

}
