<template>
  <div class="outside-div" :class="{bg_black : isOpenSignup}">
    <!--Nav Bar-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
      <a class="navbar-brand" href="http://localhost:8080">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll"
              aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon">fd</span>
      </button>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
          <!--드롭다운-->
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
              User
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Login</a></li>
              <li><a class="dropdown-item" href="#">Logout</a></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" @click="isOpenSignup=true;">Sign-up</a></li>
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
        </ul>
        <form class="d-flex">
          <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <button @click="ajaxTest">서버 호출해보기</button>

    <!--회원가입-->
    <div class="user-login-form-border" :class="{ display_block : isOpenSignup}" style="background: white">
      <form class="user-login-form">
        <div class="form-group">
          <label for="UserId">User ID</label>
          <input type="text" class="form-control" id="SignupUserIdInputBox" aria-describedby="UserIdHelp">
          <small id="UserIdHelp" class="form-text text-muted">6글자 이상 입력하세요.</small>
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">Password</label>
          <input type="password" class="form-control" id="exampleInputPassword1">
        </div>

        <div class="form-group">
          <label for="">Name</label>
          <input type="text" class="form-control">
        </div>

        <div class="form-group">
          <label for="">e-mail</label>
          <input type="text" class="form-control">
        </div>

        <div class="form-group">
          <label for="">Birth</label>
          <input type="text" class="form-control">
          <small class="form-text text-muted">ex) 2022-10-08</small>
        </div>

        <button type="submit" class="btn btn-primary user-signup-submit">Submit</button>
        <button @click="isOpenSignup=false" class="btn btn-secondary user-signup-close">Close</button>

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
  pk: 0,
  id: "haisia",
  password: "1234",
  name: "choe",
  grade: "VIP",
  money: 0,
  email: "test@google.com",
  birth: "2022-10-10",
  regDate: Date.now(),
  point: 0
}
let userJson = JSON.stringify(user);
export default {
  name: 'App',
  data() {
    return {
      isOpenSignup : false,
      userJson: userJson,
    }
  },
  components: {},
  methods: {
    ajaxTest() {
      axios.post("http://localhost:5145/user/signup", userJson, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
          .then(function (result) {
            console.log("input : " + userJson);
            console.log("output : " + result.data);
          })
    },
  },
}
</script>

<style>
.outside-div{
  position: relative;

}
.user-login-form-border {
  width: 40vw;
  position: fixed;
  margin: 0 30vw;
  /*border: black solid 2px;*/
  border-radius: 20px;
  display: none;
}

.user-login-form {
  margin: 100px;
}

.user-signup-submit {
  margin-left: 72%;
}

.display_block {
  display: block;
}
.bg_black {
  background-color: rgba(0,0,0,0.5);
}
.bg-white {}
.user-signup-close{
  margin: 8px;
}
</style>
