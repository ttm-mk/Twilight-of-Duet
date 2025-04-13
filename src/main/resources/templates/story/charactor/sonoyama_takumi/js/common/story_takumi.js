/**
 * サイドバー：巧美制御
 */

	console.log('JSファイルが読み込まれてます！');
	
	document.addEventListener('DOMContentLoaded', function () {
	  console.log('DOM読み込み完了！');
	});
		
	
	function selectStoryTakumi() {
	  const pathLinksTakumi = document.getElementById('pathLinks_takumi');
	  const clickAreaTakumi = document.getElementById('clickArea_takumi');

	    pathLinksTakumi.style.display = 'block';
	    pathLinksTakumi.innerHTML = ''; // リセット
	
	    // リンク作成
	    const link1 = document.createElement('a');
	    link1.href = '/story/charactor/sonoyama_takumi/story_pases/story_takumi1'; // 遷移先のパス
	    link1.textContent = '▶ 園山巧美　1話';
	    link1.style.display = 'block';
	    link1.style.margin = '5px 0';
	
//	    const link2 = document.createElement('a');
//	    link2.href = '/story2';
//	    link2.textContent = '▶ 物語2';
//	    link2.style.display = 'block';
//	    link2.style.margin = '5px 0';
	
	    pathLinksTakumi.appendChild(link1);
//	    pathLinks.appendChild(link2);
	
	    // クリックイベント無効化
	    clickAreaTakumi.style.pointerEvents = 'none';
//	  }
//	}
	
	document.addEventListener('DOMContentLoaded', function () {
		document.getElementById('clickArea_takumi').addEventListener('click', selectStoryTakumi);
	});
	
	

	