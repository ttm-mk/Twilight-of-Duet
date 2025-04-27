/**
 * サイドバー：メイン制御
 * 更新日：2025/4/20
 */

	console.log('JSファイルが読み込まれてます！');
	
	document.addEventListener('DOMContentLoaded', function () {
	  console.log('DOM読み込み完了！');
	});

	
	function selectStoryMain() {
	  const pathLinksMain = document.getElementById('pathLinks_main');

	    pathLinksMain.style.display = 'block';
	    pathLinksMain.innerHTML = ''; // リセット
	
	    // リンク作成
	    const link1 = document.createElement('a');
	    link1.href = '/TwilightOfDuet/story/main/1'; // 遷移先のパス(Controllerで設定したパス)
	    link1.textContent = '▶ 1話';
	    link1.style.display = 'block';
	    link1.style.margin = '5px 0';
	
	    const link2 = document.createElement('a');
	    link2.href = '/TwilightOfDuet/story/main/2';
	    link2.textContent = '▶ 2話';
	    link2.style.display = 'block';
	    link2.style.margin = '5px 0';
	
	    pathLinksMain.appendChild(link1);
		if(mainStory > 0) pathLinksMain.appendChild(link2);
	
	  }
	
  	document.addEventListener('DOMContentLoaded', function () {
      fetch('http://localhost:2102/TwilightOfDuet/api/story/story-main')
        .then(res => res.text())
        .then(data => {
          mainStory = parseInt(data, 10);	// 10新数で返してとっているらしい
          document.getElementById('clickArea_main').addEventListener('click', selectStoryMain);
        });
    });

	