import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import * as ElIcons from '@element-plus/icons'
import zhCn from 'element-plus/es/locale/lang/zh-cn'

import 'element-plus/dist/index.css'
import '@/assets/css/global.css'

const app = createApp(App)
app.config.unwrapInjectedRef = true

for (const name in ElIcons) {
  /*
   * 以elIcon为前缀的命名规则，是为了适配已经使用属性名添加图标的内置组件，
   * 例如：<el-button icon="el-icon-refresh"></el-button>
   */
  app.component('elIcon' + name, ElIcons[name])
}

app
  .use(store)
  .use(router)
  .use(ElementPlus, {
    locale: zhCn,
    size: 'small',
  })
  .mount('#app')

