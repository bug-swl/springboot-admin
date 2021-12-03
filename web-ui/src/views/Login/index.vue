<template>
  <div class="bg">
    <div class="body">
      <div style="font-size: 30px;color:white;text-align: center;padding: 30px">欢迎登录</div>
      <el-form :model="form" label-width="80px" label-position="left">
        <el-form-item label="用户名" class="item">
          <el-input prefix-icon="el-icon-user" v-model="form.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" class="item">
          <el-input show-password prefix-icon="el-icon-lock" type="password" v-model="form.password" placeholder="密码"
                    autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login" style="width: 100%;">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

import appConsole from '@/utils/console'
import { ref } from 'vue'
import request from '@/utils/request'

export default {
  name: 'login',
  setup () {
    const form = ref({
      username: '',
      password: ''
    })

    const login = () => {
      request.post('/login', form.value)
        .then(res => {
          appConsole.log(res)
        })
    }

    return {
      form,
      login
    }
  }
}
</script>

<style lang="scss">
.bg {
  width: 100%;
  height: 100vh;
  background-color: darkslateblue;
  overflow: hidden;
}

.body {
  width: 400px;
  margin: 180px auto;
}

.item .el-form-item__label {
  color: white;
}
</style>
