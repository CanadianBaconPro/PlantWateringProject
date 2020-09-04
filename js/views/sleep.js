

function sleep(ms) 
{
  return new Promise(resolve => setTimeout(resolve, ms));
}
  
async function sleep() 
{
  while(true)
  {
    await sleep(2000);
    location.reload(true/false);
  }
}
  
sleep();