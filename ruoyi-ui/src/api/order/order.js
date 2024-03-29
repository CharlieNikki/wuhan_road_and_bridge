import request from '@/utils/request'

// 查询委托信息列表
export function listOrder(query) {
  return request({
    url: '/order/order/list',
    method: 'get',
    params: query
  })
}

// 查询委托信息详细
export function getOrder(projectId) {
  return request({
    url: '/order/order/' + projectId,
    method: 'get'
  })
}

// 新增委托信息
export function addOrder(data) {
  return request({
    url: '/order/order',
    method: 'post',
    data: data
  })
}

// 修改委托信息
export function updateOrder(data) {
  return request({
    url: '/order/order',
    method: 'put',
    data: data
  })
}

// 删除委托信息
export function delOrder(projectId) {
  return request({
    url: '/order/order/' + projectId,
    method: 'delete'
  })
}
