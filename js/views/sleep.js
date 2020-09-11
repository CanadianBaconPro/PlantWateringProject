function sleeptime(ms) 
{
  return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function sleep() 
{
  while(true)
  {
    await sleeptime(200000);
    location.reload(true/false);
  }
}
  
sleep();