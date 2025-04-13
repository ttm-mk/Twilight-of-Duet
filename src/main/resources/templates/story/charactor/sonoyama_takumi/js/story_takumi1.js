/**
 * 
 */

    const texts = [
        "最初の文章が表示されています。",
        "2回目のクリックで表示される文章です。",
        "3回目のクリックで表示される文章です。",
        "クリックが終わりました。"
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
	window.addEventListener('DOMContentLoaded', () => {

	    document.getElementById('clickArea').addEventListener('click', changeText);
		
	});

