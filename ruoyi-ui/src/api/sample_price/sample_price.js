import request from '@/utils/request'

// 查询样品价格列表
export function listSample_price(query) {
  return request({
    url: '/sample_price/sample_price/list',
    method: 'get',
    params: query
  })
}

// 查询样品价格详细
export function getSample_price(id) {
  return request({
    url: '/sample_price/sample_price/' + id,
    method: 'get'
  })
}

// 新增样品价格
export function addSample_price(data) {
  return request({
    url: '/sample_price/sample_price',
    method: 'post',
    data: data
  })
}

// 修改样品价格
export function updateSample_price(data) {
  return request({
    url: '/sample_price/sample_price',
    method: 'put',
    data: data
  })
}

// 删除样品价格
export function delSample_price(id) {
  return request({
    url: '/sample_price/sample_price/' + id,
    method: 'delete'
  })
}
