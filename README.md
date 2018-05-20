# algorithm
アルゴリズムの練習を行うアプリケーションです。探索やソートのアルゴリズムをJavaプログラムで実装します。

## アプリケーションの構成
### Directory構成
このアプリケーションは、
- ソート
- 探索
の基礎的なアルゴリズムのビジネスロジックを中心としています。  
├──Abstracts  
│   └─LogicUtils.java
└──Logic  
    ├──Search  
    │   ├─SearchImpl.java  
    │   └─SearchMeisuringImpl.java  
    └──Sort  
        ├─SortImpl.java  
        └─SortMeisuringImpl.java  
mainクラスは、各実装を呼び出し、結果の表示を行うことに特化して利用します。
### アプリのビルド
本アプリは、mavenでライブラリをビルトしています。

## 実装
以下のアルゴリズムを実装します。ここでは、便宜上整数値可変長配列を対象とした探索とソートを学習します。
### 探索
- 線形探索法
- 二分探索法
- ハッシュ探索法※under construction
### ソート
- 単純選択法
- 単純交換法
- クイックソート

