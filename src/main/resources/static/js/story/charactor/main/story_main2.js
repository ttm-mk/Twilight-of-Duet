/**
 * ストーリー：メイン2
 * 制御
 * 更新日：2025/4/29
 */

const userId = /*[[${userId}]]*/ 1;

// クリックカウント用
let count = 0;
let texts = [];
// 好感度
let affection = {
	"巧美": 0,
	"颯真": 0,
	"御幸": 0,
	"巧斗": 0,
	"実瑠": 0
};

// 名前、あだ名、StoryId、MainStoryIntの取得
Promise.all([
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine`).then(res => res.text()),
  fetch(`http://localhost:2102/TwilightOfDuet/api/users/heroine-nickname`).then(res => res.text())

])

.then(([heroineName, heroineNickname]) => {
  // 値がなければデフォルトを使う
  if (!heroineName) heroineName = "鳴海千晴";
  if (!heroineNickname) heroineNickname = "ちい";

    // 文章
    texts = [
		"メインストーリー　2話",
		`${heroineName}：選択肢を表示させたい${heroineNickname}`,

		"選択肢を表示するよ。どっちを選ぶ？",
		
		{ type: "choice", choices: [
			
				{ text: "▶好感度をあげる",
				  affection: 10,
				  extraText: "好感度が上がったよ！",
				  charactor: "巧美"
				},
				
				{ text: "▶好感度をさげる",
				  affection: -5,
			 	  extraText: "好感度が下がったよ！",
				  charactor: "巧美"
			  	}
			]
		},
		
		"さて、テーブルの値をみてみよう。好感度はどうなっているかな",
		"テーブルは見たかな？好感度大丈夫だといいね"
	];

    // 表示エリアを取得し、texts[0]を入れこむ
    document.getElementById('textMain2').textContent = texts[0];

    // イベント設定（この中でやってもいい）
    document.getElementById('clickArea_main2').addEventListener('click', advenceText);
  })
  .catch(error => {
    console.error("名前の取得失敗:", error);
	
    // 失敗したときも同じようにデフォルトで動かす
    texts = [
		"デフォルト用"
    ];
	
    document.getElementById('textMain2').textContent = texts[0];
    document.getElementById('clickArea_main2').addEventListener('click', advenceText);
	
  });

  // TODO：値を入れたので値を返して更新する処理を追記する必要あり（こことController）
//  // メインストーリーカラムに数値の値を返す
//  fetch('http://localhost:2102/TwilightOfDuet/api/story/main/complete', {
//  	
//  	method: 'POST',
//  	headers: {
//  		'Content-Type':'application/json'
//  	},
//  	body: JSON.stringify({"mainStory": 2})
//
//  	
//  })
//  .then(response => response.json())
//  .then(data => console.log("サーバ応答:", data));



// 表示制御
function advenceText(){
	const textElement = document.getElementById('textMain2');
	const clickAreaElement = document.getElementById('clickArea_main2');

	const current = texts[count];
	
	if(typeof current === "string"){
		textElement.textContent = current;
		count++; // そのまま進める処理
		
	} else if(current.type === "choice"){
		showChoices(current.choices);
		return; // 選択肢を選ぶまで進めない処理
		
	}
	
	if(count >= texts.length){
		clickAreaElement.style.pointerEvents = "none";
		
	}
}

function showChoices(choices) {
    const textElement = document.getElementById('textMain2');
	const clickAreaElement = document.getElementById('clickArea_main2');
	textElement.innerHTML = ""; // 選択肢表示エリアをクリア
	
	choices.forEach(choice => {
		const choiceText = document.createElement('p');
		choiceText.textContent = choice.text; // textContentを使って選択肢をHTMLに表示する
		choiceText.style.display = "block"; // 改行させるためにブロック扱いにするらしい
		choiceText.style.cursor = "pointer"; // ユーザーにクリックできると伝える
		choiceText.onclick = () => {
			// キャラクターの指定と好感度
			const character = choice.character
			if (character) {
			    affection[character] += choice.affection;
			  }
			// extraText を今の次の位置に挿入（count + 1 の位置）
			texts.splice(count + 1, 0, choice.extraText);
			// extraText を texts に追加
			textMain2.textContent = choice.extraText;
			// 次のクリックで進むように一時停止
			const clickAreaElement = document.getElementById('clickArea_main2');
			count++; // 次に進める
			clickAreaElement.addEventListener('click', advenceText, { once: true }); // 1回だけ有効
		};
		
		textMain2.appendChild(choiceText); // textMain2(親要素)にchoiceText(子要素)に追加する処理
	});
}

