<template>
  <!--  <div class="outside-div" :class="{bg_black : isOpenSignup,-->
  <!--                                    bg_black : isOpenLogin}">-->
  <div class="outside-div"
       :class="{bg_black : is.OpenSignup || is.OpenLogin || is.SubmitSignup}">
    <!--Nav Bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
      <a class="navbar-brand" href="http://localhost:8080">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll"
              aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
          <!--드롭다운-->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="false">
              User
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" @click="closeAll(); is.OpenLogin=true;">Login</a></li>
              <li><a class="dropdown-item" href="#">Logout</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" @click="closeAll(); is.OpenSignup=true;">Sign-up</a></li>
            </ul>
          </li>
          <!--#######################################-->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              Board
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item"
                     @click="url='http://localhost:5145/board/free/article';
                      getApiCall();
                      closeAll();
                      is.OpenFreeBoard=true;
              ">Free Board</a></li>
              <li><a class="dropdown-item">Board2</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item">Board3</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              테스트용
            </a>
            <ul class="dropdown-menu">
              <li><a @click="getTest" class="dropdown-item">GET</a></li>
              <li><a @click="postTest" class="dropdown-item">POST</a></li>
              <li><p @click="testLog" class="dropdown-item">Log</p></li>
            </ul>
          </li>
        </ul>

        <!--서치바-->
        <!--        <form class="d-flex">-->
        <!--          <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search">-->
        <!--          <button class="btn btn-outline-success" type="submit">Search</button>-->
        <!--        </form>-->
      </div>
    </nav>

    <!--회원가입-->
    <!--##########################################################################-->
    <!--##########################################################################-->
    <!--##########################################################################-->
    <!--##########################################################################-->
    <div class="user-form-modal" :class="{ display_block : is.OpenSignup}" style="background: white">
      <form class="user-signup-form" @submit.prevent="function(){
        let _url = 'http://localhost:5145/user/signup';
        postApiCall(_url, user);
      }">
        <h2>Sign-up</h2>
        <div class="form-group">
          <label>User ID</label>
          <input v-model="user.id" type="text" class="form-control">
          <small id="UserIdHelp" class="form-text text-muted">6글자 이상 입력하세요.</small>
        </div>
        <div class="form-group">
          <label>Password</label>
          <input v-model="user.password" type="password" class="form-control">
        </div>
        <div class="form-group">
          <label>Name</label>
          <input v-model="user.name" type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>E-mail</label>
          <input v-model="user.email" type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>Birth</label>
          <input v-model="user.birth" type="text" class="form-control">
          <small class="form-text text-muted">ex) 2022-10-08</small>
        </div>
        <button type="submit" class="btn btn-primary user-signup-submit"
                @click="closeAll();">Submit
        </button>
        <button type="reset" @click="closeAll();" class="btn btn-secondary user-signup-close">Close</button>
      </form>
      <!--#################로그인############################-->
    </div>


    <div class="user-form-modal" :class="{display_block : is.OpenLogin}" style="background-color:white;">
      <!--      <form class="user-login-form" @submit.prevent="userLoginApiCall">-->
      <form class="user-login-form"
            @submit.prevent="function(){
              let _url = 'http://localhost:5145/user/login'
              postApiCall(_url, login);
            }">
        <h2>Login</h2>
        <div class="form-group">
          <label>ID</label>
          <input v-model="login.id" type="text" class="form-control">
          <small class="form-text text-muted">아이디는 6글자 이상</small>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input v-model="login.password" type="password" class="form-control">
        </div>
        <div class="form-group form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1">
          <label class="form-check-label">Remember ID</label>
        </div>
        <button type="submit" @click="closeAll();" class="btn btn-primary">Submit</button>
        <button type="reset" @click="closeAll();" class="btn btn-secondary user-signup-close">Close</button>
      </form>
    </div>

    <!--Free Board List-->
    <div class="board-container" :class="{display_block:is.OpenFreeBoard}">
      <table class="table free-board">
        <thead>
        <tr>
          <th scope="col" class="board-number">#</th>
          <th scope="col" class="board-title">Title</th>
          <th scope="col" class="board-writer">Writer</th>
          <th scope="col" class="board-viewcount">View</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(data, i) in result" :key="i">
          <th scope="row" style="text-align: center">{{ data.pk }}</th>
          <td @click="closeAll();
                      clickedArticleIndex = i;
                      is.OpenFreeBoardArticle=true;
          ">{{ data.title }}
          </td>
          <td>{{ data.writer }}</td>
          <td>{{ data.viewCount }}</td>
        </tr>
        </tbody>
      </table>
      <button style="float: right" type="button" class="btn btn-primary"
              @click="closeAll();
                      is.OpenFreeBoardWriteForm = true;">글쓰기</button>
    </div>

    <!--Free Board Article-->
    <div class="board-container" :class="{display_block:is.OpenFreeBoardArticle}">
      <h5 style="border-top: slategrey solid 1px">{{ result[clickedArticleIndex].title }}</h5>
      <div style="border-bottom: slategrey solid 1px">
        <span>{{ result[clickedArticleIndex].writer }} | {{ result[clickedArticleIndex].writeDate }}</span>
        <span
            style="float: right">조회 {{
            result[clickedArticleIndex].viewCount
          }} | 댓글 {{ result[clickedArticleIndex].commentCount }}</span>
      </div>
      <div style="height: 650px;">
        {{ result[clickedArticleIndex].content }}
      </div>
      <button @click="closeAll(); is.OpenFreeBoard=true;" style="float: right" type="button" class="btn btn-secondary">
        목록으로
      </button>
    </div>

<!--write to free board-->
    <div class="board-container" :class="{display_block : is.OpenFreeBoardWriteForm}">
      <form @submit.prevent="function(){
        let _url='http://localhost:5145/boar/free/article';
        postApiCall(_url, article);
      }">
        <div class="input-group mb-3" style="width:300px">
          <div class="input-group-prepend">
            <span style="width:70px" class="input-group-text">작성자</span>
          </div>
          <input type="text" class="form-control" v-model="article.writer">
        </div>
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <span style="width:70px" class="input-group-text">제목</span>
          </div>
          <input type="text" class="form-control" v-model="article.title">
        </div>
        <div class="input-group mb-3">
          <textarea style="height: 600px" class="form-control" v-model="article.content"/>
        </div>
        <button style="margin-right: 7px; float: right;" type="submit" class="btn btn-primary" @click="closeAll(); is.OpenFreeBoard=true;">등록</button>
        <button style="margin-right: 7px; float: right;" type="button" class="btn btn-secondary" @click="closeAll(); is.OpenFreeBoard=true;">취소</button>
      </form>
    </div>


    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

  </div>
</template>

<script>

import axios from 'axios'

let user = {
  pk: "",
  id: "",
  password: "",
  name: "",
  grade: "",
  money: 0,
  email: "",
  birth: "",
  regDate: Date.now(),
  point: 0
}
let login = {
  id: "",
  password: "",
}

let article = {
  pk: "",
  title: "",
  content: "",
  writer: "",
  writeDate: "",
  viewCount: "",
  commentCount: "",
}

export default {
  name: 'App',
  data() {
    return {
      clickedArticleIndex: 0,
      user: user,
      login: login,
      article: article,
      is: {
        OpenSignup: false,
        SubmitSignup: false,
        OpenLogin: false,
        OpenFreeBoard: false,
        OpenFreeBoardArticle: false,
        OpenFreeBoardWriteForm: false,
      },

      url: "",
      data: {},
      result: [{
        pk: "",
        title: "",
        writer: "",
        writeDate: "",
        viewCount: "",
        commentCount: "",
      }],
    }
  },
  components: {},
  methods: {


    closeAll() {
      for (let key in this.is) {
        this.is[key] = false;
      }
    },

    testLog() {
      console.log("#####################");
      for (let key in this.is) {
        console.log(this.is.key);
        console.log(key)
      }
      console.log("#####################");

      this.is.OpenLogin = false;
      this.is.OpenSignup = false;
      this.is.OpenFreeBoard = false;
      this.is.SubmitSignup = false;
    },
    getTest() {
      axios.get("http://localhost:5145/board/free/article");
    },
    postTest() {
      axios.post("http://localhost:5145/posttest", JSON.stringify(login), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
    },

    async getApiCall() {
      let result;
      await axios.get(this.url).then(function (e) {
        result = e.data;
      });
      this.result = result;
      console.log(this.result);
      console.log(typeof this.result[0]);
    },
    postApiCall(url, _data) {
      let jsonData = JSON.stringify(_data);
      console.log(jsonData);
      axios.post(url, jsonData, {
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(function (e) {
        console.log(e.data);
      });
    },
  },
}
</script>

<style>
.outside-div {
  position: relative;

}

.user-form-modal {
  width: 40vw;
  position: fixed;
  margin: 0 30vw;
  border-radius: 20px;
  display: none;
}

.user-signup-form {
  margin: 50px 100px;
}

.user-login-form {
  margin: 50px 100px;
}


.user-signup-submit {
  /*margin-left: 70%;*/
}

.bg_black {
  background-color: rgba(0, 0, 0, 0.5);
}

.bg-white {
}

.user-signup-close {
  margin: 8px;
}

.board-container {
  margin: 5vw 10vw;
  display: none;
}

.board-number {
  width: 70px;
  text-align: center;
}

.board-title {
  width: 60vw;
  text-align: center;
}


.display_block {
  display: block;
}
</style>
