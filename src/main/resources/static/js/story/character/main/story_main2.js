/**
 * ストーリー：メイン2
 * 制御
 * 更新日：2025/5/8
 */


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
				  character: "巧美"
				},
				
				{ text: "▶好感度をさげる",
				  affection: -5,
			 	  extraText: "好感度が下がったよ！",
				  character: "巧美"
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
	
	// 最後まで行った後の処理
	// TODO：ここはおいおい別functionで整理。好感度とストーリー別個の処理記載して
	// 　　　aysncで順番と、その順番を決めるfunction書くこと。とりあえず後回しで。
	if(count >= texts.length){
		clickAreaElement.style.pointerEvents = "none";
		
		// まず好感度送信 → それが成功したらストーリー送信
		fetch('http://localhost:2102/TwilightOfDuet/api/likeability/add', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				"takumiLikeability": affection["巧美"],
				"somaLikeability": affection["颯真"],
				"miyukiLikeability": affection["御幸"],
				"takutoLikeability": affection["巧斗"],
				"miruLikeability": affection["実瑠"],
				"storyNumber": 2,
				"storyType": "main"
				
			})
		})
		// async:順序を決める処理を記載↓↓↓好感度⇒ストーリー
		.then(async likeabilityResponse => {
			if (likeabilityResponse.ok) {
				console.log("好感度送信完了");

				// 好感度が保存された後にストーリーの値を返す処理のようだ
				return fetch('http://localhost:2102/TwilightOfDuet/api/story/main/complete', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify({
						"mainStory": 2
					})
				});
				
			} else {
				console.warn("好感度送信失敗");
				throw new Error("好感度送信失敗");
				
			}
		})
		// 上が成功したら次はここの処理になる
		.then(async storyResponse => {
			if (storyResponse && storyResponse.ok) {
				// await:完了するまで待たせる（順番は最初にlikeabilityResponseのためそれが完了し次第）
				const data = await storyResponse.json();
				console.log("ストーリー送信完了:", data);
				
			} else {
				console.warn("ストーリー送信失敗");
			}
		})
		.catch(error => {
			console.error("送信エラー:", error);
			
		});
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
			// キャラクターの指定と好感度処理
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

