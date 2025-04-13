/**
 * サイドバー：巧美制御
 * 更新日：2025/4/13
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
	    link1.href = '/TwilightOfDuet/story/SonoyamaTakumi/1'; // 遷移先のパス(Controllerで設定したパス)
	    link1.textContent = '▶ 1話';
	    link1.style.display = 'block';
	    link1.style.margin = '5px 0';
	
//	    const link2 = document.createElement('a');
//	    link2.href = '/story2';
//	    link2.textContent = '▶ 物語2';
//	    link2.style.display = 'block';
//	    link2.style.margin = '5px 0';
	
	    pathLinksTakumi.appendChild(link1);
//	    pathLinksTakumi.appendChild(link2);
	
	  }
//	}
	
	document.addEventListener('DOMContentLoaded', function () {
		document.getElementById('clickArea_takumi').addEventListener('click', selectStoryTakumi);
	});
	
	

	