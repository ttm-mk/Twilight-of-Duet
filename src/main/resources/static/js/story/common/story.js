/**
 * 
 */

	const texts = [
	    "枠内をクリックすることで、文章が進みます。",
	    "いまのところ戻ることはできません。さきにすすむだけです。",
	    "リロードすると最初に戻りますので、お気をつけください。",
	    "疑問点がありましたら、お問い合わせからご連絡ください。",
		"それではサイドバーから読みたいストーリーを選択しておたのしみください。"
	];
	
	let count = 0; // クリック回数をカウント
	
	function changeText() {
	    const textElement = document.getElementById('text');
	    const clickAreaElement = document.getElementById('clickArea');
	    
	    // 配列内の文章を順番に表示
	    textElement.textContent = texts[count];
	    count++;
	    
	    // クリック数が配列の長さに達したらクリックエリアを無効化
	    if (count >= texts.length) {
	        clickAreaElement.style.pointerEvents = 'none'; // クリックイベントを無効化
	    }
	}
	
	// クリックエリアにクリックイベントを追加
	document.getElementById('clickArea').addEventListener('click', changeText);