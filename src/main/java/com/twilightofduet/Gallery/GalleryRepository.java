package com.twilightofduet.Gallery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Galleryリポジトリ
 * 作成者 tsutsumi miki
 * 編集日 2025/2/24 tsutsumi miki
 */

@Repository
public interface GalleryRepository extends JpaRepository<GalleryEntity, Integer> {

}
