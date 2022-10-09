<template>
  <!--  <div class="outside-div" :class="{bg_black : isOpenSignup,-->
  <!--                                    bg_black : isOpenLogin}">-->
  <div class="outside-div" :class="{bg_black : isOpenSignup || isOpenLogin}">
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
              <li><a class="dropdown-item" @click="isOpenLogin=true; isOpenSignup=false">Login</a></li>
              <li><a class="dropdown-item" href="#">Logout</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" @click="isOpenSignup=true; isOpenLogin=false">Sign-up</a></li>
            </ul>
          </li>
          <!--#######################################-->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              Board
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Board1</a></li>
              <li><a class="dropdown-item" href="#">Board2</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#">Board3</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              테스트용
            </a>
            <ul class="dropdown-menu">
              <li><a @click="getTest" class="dropdown-item">GET</a></li>
              <li><a @click="postTest" class="dropdown-item">POST</a></li>

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
    <div class="user-form-modal" :class="{ display_block : isOpenSignup}" style="background: white">
      <form class="user-signup-form" @submit="userSignupApiCall">
        <h2>Sign-up</h2>
        <div class="form-group">
          <label>User ID</label>
          <input v-model="user.id" type="text" class="form-control" aria-describedby="UserIdHelp">
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
        <button type="submit" class="btn btn-primary user-signup-submit" @click="isOpenSignup=false;">Submit</button>
        <button type="reset" @click="isOpenSignup=false" class="btn btn-secondary user-signup-close">Close</button>
      </form>
      <!--#################로그인############################-->
    </div>


    <div class="user-form-modal" :class="{display_block : isOpenLogin}" style="background-color:white;">
      <form class="user-login-form" @submit="userLoginApiCall" >
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
        <button type="submit" @click="isOpenLogin=false" class="btn btn-primary">Submit</button>
        <button type="reset" @click="isOpenLogin=false" class="btn btn-secondary user-signup-close">Close</button>
      </form>
    </div>


    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

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
export default {
  name: 'App',
  data() {
    return {
      user: user,
      login: login,
      isOpenSignup: false,
      isSubmitSignup: false,
      isOpenLogin: false,
    }
  },
  components: {},
  methods: {
    getTest() {
      axios.get("http://localhost:5145/gettest");
    },
    postTest() {
      axios.post("http://localhost:5145/posttest", JSON.stringify(login), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
    },
    userSignupApiCall() {
      axios.post("http://localhost:5145/user/signup", JSON.stringify(user), {
        headers: {
          'Content-Type': 'application/json'
        }
      });
    },
    userLoginApiCall() {
      axios.post("http://localhost:5145/user/login", JSON.stringify(login), {
        headers: {
          'Content-Type': 'application/json'
        }
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

.display_block {
  display: block;
}

.bg_black {
  background-color: rgba(0, 0, 0, 0.5);
}

.bg-white {
}

.user-signup-close {
  margin: 8px;
}
</style>
